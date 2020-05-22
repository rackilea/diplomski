public void someMethodInsertList(List<SomeObject> list){
       //normally I do an implementation that allows me to use
       //sqlSessionTemplate from mybatis through an extended class 
       for ( SomeObject obj : list ){
           obj.setId( getSqlSessionTemplate.selectOne( 'nextvalKey' ) );
       }
       getSqlSessionTemplate.insert( 'insertServiceMappings', list );
  }