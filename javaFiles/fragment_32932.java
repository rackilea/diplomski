package org.hibernate.hql.spi.id.global;

import java.util.concurrent.*;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.springframework.util.ClassUtils;
import com.ibm.cics.server.*;

public class CicsAwareGlobalTemporaryTableBulkIdStrategy extends GlobalTemporaryTableBulkIdStrategy {

    @Override
    protected void finishPreparation(JdbcServices jdbcServices, JdbcConnectionAccess connectionAccess, MetadataImplementor metadata, PreparationContextImpl context) {
        execute(() -> super.finishPreparation(jdbcServices, connectionAccess, metadata, context));
    }

    @Override
    public void release(JdbcServices jdbcServices, JdbcConnectionAccess connectionAccess) {
        execute(() -> super.release(jdbcServices, connectionAccess));
    }

    private void execute(Runnable runnable) {
        if (isCics() && IsCICS.getApiStatus() == IsCICS.CICS_REGION_BUT_API_DISALLOWED) {
            RunnableFuture<Void> task = new FutureTask<>(runnable, null);
            CICSExecutorService.runAsCICS(task);
            try {
                task.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException("Failed to execute in a CICS API-enabled thread. " + e.getMessage(), e);
            }
        } else {
            runnable.run();
        }
    }

    private boolean isCics() {
        return ClassUtils.isPresent("com.ibm.cics.server.CICSExecutorService", null);
    }
}