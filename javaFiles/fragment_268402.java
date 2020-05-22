val sf = new SimpleDateFormat("M/d/yyyy")
  val now = new Date
  val cal = Calendar.getInstance()
  cal.set(2013, 0, 1) //Jan 1 2013

  val dates = 
    Iterator.
      continually{
        val d = cal.getTime
        cal.add(Calendar.DAY_OF_YEAR, 1)
        sf.format(d)
      }.
      takeWhile(_ => cal.getTimeInMillis() <= now.getTime).
      toSeq