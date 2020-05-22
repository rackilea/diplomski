for (Iterator<Doc> iterator = doc.iterator(); iterator.hasNext(); ) {
      Date date = iterator.next().getDate();

      if( (param.getFromDateTime() != null && date.before(params.getFromTime())) 
          || (params.getToDateTime() != null && date.after(params.getToDateTime()))) {
        iterator.remove();
      }

}