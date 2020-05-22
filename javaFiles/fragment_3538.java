class BarChartStyles : Stylesheet() {

    companion object {
        val backColor = c("#4682B4")
        val chartBar by cssclass()
    }

    init {
        chartBar {
            barFill = backColor
        }
    }
}