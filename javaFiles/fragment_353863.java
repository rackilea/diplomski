IntStream.range(0, params.size())
  .forEach(idx ->
    query.bind(
      idx,
      params.get(idx)
    )
  )
;