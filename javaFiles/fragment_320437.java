SIZE <- 50000

lengths <- sample(1000:10000, SIZE, replace=T)
nonzeros <- sample(1:100, SIZE, replace=T)

f.rle <- function(len, nonzero) {
  indexes <- sort(c(0,sample(1:len, nonzero, F)))
  steps <- diff(indexes)
  sum(steps > 1) + nonzero # one short per run of zeros, and one per zero
}

f.index <- function(len, nonzero) {
  nonzero * 2
}

# using the [value, -1 * number of zeros,...] method
rle.comprs <- mapply(f.rle, lengths, nonzeros)
print(mean(lengths - rle.comprs)) # average number of shorts saved

rle.ratios <- rle.comprs / lengths * 100
print(mean(rle.ratios)) # average compression ratio

# using the [(index, value),...] method
index.comprs <- mapply(f.index, lengths, nonzeros)
print(mean(lengths - index.comprs)) # average number of shorts saved

index.ratios <- index.comprs / lengths * 100
print(mean(index.ratios)) # average compression ratio


par(mfrow=c(2,1))
hist(rle.ratios, breaks=100, freq=F, xlab="Compression ratio (%)", main="Run length encoding")
hist(index.ratios, breaks=100, freq=F, xlab="Compression ratio (%)", main="Store indices")