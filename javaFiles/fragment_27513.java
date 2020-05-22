@Mapper
public abstract class ConstraintsPostProcessor {

    @Inject
    private UserService userService; // can use normal Spring DI here

    @AfterMapping
    public void setConstraintsOnMissionTreeDTO(Mission mission, @MappingTarget MissionDTO dto){ // do not forget the @MappingTarget annotation or it will not work
        dto.setUser(userService.getCurrentUser()); // can do any additional logic here, using services etc.
    }
}