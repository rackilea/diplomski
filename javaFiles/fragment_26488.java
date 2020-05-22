metricKeys.map { key =>
  matricsData.get(key) match {
    case Some(value) => if (value) "Y" else "N"
    case None        => StringUtils.EMPTY
  }
}