val fontFields = R.font::class.java.fields
val fonts = arrayListOf<Int>()

for (field in fontFields) {
    try {
        Log.i("TAG", field.name)
        fonts.add(field.getInt(null))
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

for(font in fonts){
    val typeface = appContext.resources.getFont(font)
    println(typeface.isBold)
}