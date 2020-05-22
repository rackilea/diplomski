public List<? extends Creature> getGroup(Object obj) {

      if(obj.getClass() == Bee.class)
          return ((Bee)obj).getColony();

      if(obj.getClass() == Fish.class)
          return ((Fish) obj).getSchool();

      /* repeat for the other classes */

      return null;
  }