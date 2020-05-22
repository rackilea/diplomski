@Produces
public NonCdiClass produceNonCdiClass(MyFisrtBean param1, MySecondBean param2) {
    NonCdiClass res = new NonCdiClass(param1);
    res.setParam(param2);
    return res;
    };
}