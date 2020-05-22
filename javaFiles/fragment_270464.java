public void postFlush(Iterator iterator) {


for(; iterator.hasNext();) {
   if(!(iterator.next() instanceof Item)){ //<<<<< You verify if you are saving Item or //other objects, if saving Item, skip this block.

   Session tempSession = HibernateUtil.hibernateTemplateLog
            .getSessionFactory().openSession();

    try {
        Item item = new Item();
        item.setName("anyItem");
        item.setValue("anyValue");
        tempSession.save(item);
        tempSession.flush();
    } finally {
        tempSession.close();
    }
}
}
    }
}