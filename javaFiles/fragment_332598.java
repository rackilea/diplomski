@SqlResultSetMapping(
        name = "TeamInformation",
                classes = {
                         @ConstructorResult(targetClass = TeamListInformation.class,
                           columns = {@ColumnResult(name="id", type = Integer.class) , 
                                   @ColumnResult(name="name", type = String.class), 
                                   @ColumnResult(name="rating", type = Integer.class), 
                                   @ColumnResult(name="country", type = String.class),  
                                   @ColumnResult(name="division", type = String.class), 
                                   @ColumnResult(name="games", type = String.class)}
                         )}

        )