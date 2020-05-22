DockerClient dockerClient = DockerClientBuilder.getInstance("http://localhost:2375").build();
 List<Image> images = dockerClient.listImagesCmd().exec();

    for(int i=0; i < images.size(); i++){
        System.out.println(images.get(i));
    }