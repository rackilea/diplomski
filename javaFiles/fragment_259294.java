private static void getSubTypes(Types type)
{
    SubTypes[] values = SubTypes.values();
    for(SubTypes value : values)
    {
        if(value.t == type){
            System.out.println("found subtype "+ value);
        }
    }

}