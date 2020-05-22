main(books: { 30 50 5 60 90 5 80 }, K: 3)

define main(books, K)
  writers = books
  while writers.length > K do
    reduceMinimalPair(writers)
  endwhile
end

define reduceMinimalPair(items)
  index = 0
  minvalue = items[0] + items[1]
  for i in 1..items.length-1 do
    if items[i] + items[i + 1] < minvalue then
      index = i
      minvalue = items[i] + items[i + 1]
    endif
  endfor
  items.removeat(index)
  items.removeat(index + 1)
  items.insertat(index, minvalue)
end