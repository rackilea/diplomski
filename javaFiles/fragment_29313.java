private fun getTimes(array: JSONArray): Array<Timepoint> {
    val times = arrayListOf<Timepoint>()
    for (i in 0..array.length().minus(1)) {
        val format = SimpleDateFormat("HH:mm", Locale.getDefault())

        val start = Calendar.getInstance()
        start.time = format.parse(array.getJSONObject(i).getString("start"))

        val end = Calendar.getInstance()
        end.time = format.parse(array.getJSONObject(i).getString("end"))

        while (!start.after(end)) {
            times.add(Timepoint(start.get(Calendar.HOUR_OF_DAY), start.get(Calendar.MINUTE)))
            start.add(Calendar.MINUTE, 1)
        }
    }

    return times.toArray(arrayOfNulls<Timepoint>(times.size))
}