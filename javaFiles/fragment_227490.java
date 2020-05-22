@Mapper(uses = BooleanYNMapper.class)
interface MyMapper{
    Target map(Source s);
    //and even this will work:
    Source mapBack(Target t);
}