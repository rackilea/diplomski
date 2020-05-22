import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.InspectContainerResponse;
import com.github.dockerjava.api.command.ListContainersCmd;
import com.github.dockerjava.api.command.ListImagesCmd;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.Image;
import com.github.dockerjava.core.DockerClientBuilder;

String localDockerHost = SystemUtils.IS_OS_WINDOWS ? "tcp://localhost:2375" : "unix:///var/run/docker.sock";
DockerClient dockerClient = DockerClientBuilder.getInstance(localDockerHost).build();
List<Container> containers = dockerClient.listContainersCmd().exec();

    for(int i=0; i < containers.size(); i++){
        System.out.println(containers.get(i));
    }