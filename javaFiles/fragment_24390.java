import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.model.HostConfig;

HostConfig hostConfig = HostConfig
  .newHostConfig()
  .withAutoRemove(true);             // Set the "remove" flag

CreateContainerResponse container = dockerClient
  .createContainerCommand("busybox")
  .withHostConfig(hostConfig)        // Add in the HostConfig object
  .exec();