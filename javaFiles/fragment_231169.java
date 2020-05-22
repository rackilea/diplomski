import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.google.common.base.Suppliers;

@Service
public class JdkVersionService {

    private final Supplier<JdkVersion> latestJdkVersionCache;

    @Inject
    public JdkVersionService(JdkVersionWebService jdkVersionWebService) {
        this.latestJdkVersionCache = Suppliers.memoizeWithExpiration(
                jdkVersionWebService::checkLatestJdkVersion,
                365, TimeUnit.DAYS
        );
    }

    public JdkVersion getLatestJdkVersion() {
        return latestJdkVersionCache.get();
    }
}