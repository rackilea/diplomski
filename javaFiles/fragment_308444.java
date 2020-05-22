finally {
                    Obj1 = null;
                    Obj2 = null;
                    if (entityTransaction.isActive())
                        entityTransaction.rollback();
                    em.clear();
                    em.close();

                }