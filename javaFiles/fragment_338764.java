import org.nd4j.linalg.api.memory.MemoryWorkspace;
import org.nd4j.linalg.api.memory.conf.WorkspaceConfiguration;
import org.nd4j.linalg.api.memory.enums.LocationPolicy;
WorkspaceConfiguration mmap = WorkspaceConfiguration.builder()
            .initialSize(initialSize)
            .policyLocation(LocationPolicy.MMAP)
            .build();

try (MemoryWorkspace ws =   
           Nd4j.getWorkspaceManager().getAndActivateWorkspace(mmap)) {
 //load your word2vec here            

}