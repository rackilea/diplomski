public class UserControllerMocked extends UserController {
    @Override
    create (Entity entity){ ... your mock code ....};
    @Override
    Entity update (Entity entity){ ... your mock code ... return entity};
}