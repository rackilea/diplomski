public static COjbect getClosestRecordToDate(final List<CObject> list, final Date date)
{
     if (list == null || list.isEmpty())
          return null;

     final CObject temp = list.get(0);

     for (final CObject obj : list)
     {
          final long time = obj.getDate().getTime();

          if (time < date.getTime() && time > temp.getTime())
               temp = obj;
     }

     return temp;
}