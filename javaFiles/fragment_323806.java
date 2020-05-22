JAXBContext context = JAXBContext.newInstance(Response.class, Project.class, User.class, Wrapper.class);
Unmarshaller unmarshaller = context.createUnmarshaller();

StreamSource source = new StreamSource(new File("responseProject.xml"));
Response<Project> responseProject = (Response<Project>)unmarshaller.unmarshal(source);
System.out.println(responseProject.getStatus());
for (Project project:responseProject.getResult()) System.out.println(project);

source = new StreamSource(new File("responseUser.xml"));
Response<User> responseUser = (Response<User>)unmarshaller.unmarshal(source);
System.out.println(responseUser.getStatus());
for (User user:responseUser.getResult()) System.out.println(user);