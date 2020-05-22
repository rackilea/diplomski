OutParameters result = handle
        .createCall("{:sum = call add(:a, :b)}") 
        .bind("a", 13) 
        .bind("b", 9) 
        .registerOutParameter("sum", Types.INTEGER)   
        .invoke();