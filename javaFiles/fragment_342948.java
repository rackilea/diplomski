# 1.You will require a structDescriptor object for an object equivalent in pl sql like :

    StructDescriptor structDes= new StructDescriptor("<schemaname in caps>.<sql_object_name>", connectionObject);

    # 2. You will need to pass one object values such name, class, id to an object array in order and accordance to 'sql_object_name' object. 

    For exmaple:
    STRUCT[] structArray=new STRUCT[<ListObj>.size()];
    int index=0;
    for (a in ListObj){

    Object[] object=new Object[]{a.getName(),a.getId()};
    STRUCT struct=new STRUCT(structDes ,connectionObject,object);
               structArray[index]=struct;
               index++;

    }

    ArrayDescriptor arrayDes=ArrayDescriptor.createDescriptor(
        "<Schema name>.<table object from sql>", connectionObject);

    ARRAY array=new ARRAY(arrayDes,connectionObject, structArray);

   then pass it to proc 

   .declareParameters(
   new SqlInOutParameter("<parameter to proc name>",OracleTypes.ARRAY,"
   <schema name>.<sql_array_or_table_obj>"))

   like 
   Hashmap<String, Object> map= new HashMap<>();
   map.put("<parameter to proc name>",array);
   psStatement.execute(map);