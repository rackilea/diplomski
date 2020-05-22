files     <- list.files(pattern = "\\.(txt)")
files.ID  <- substr(basename(files), 1, 7)  #SUBSTR() takes the first 7 characters of the name of each file

#TO OBTAIN THE DATE FROM THE FILE TITLE
a <- unlist(strsplit(unlist(files), "[^0-9]+"))  #takes all the numeric sequences from each string in the vector "files" - the first one is a space (all filenames have a space as first character - the second is the ID, the third is the date as DDMMYY ("010513")
b <- a[seq(3, length(a), 3)]  #I take only the every 3rd string which is the sequence of the date.
d <- paste(substr(b,1,2),"/",substr(b,3,4),"/",substr(b,5,6), sep="") #creates the date as dd/mm/yy
files.date <- as.POSIXct(d,format="%d/%m/%Y")

x <- length(files)
j <- 1
reports<-data.frame(matrix(0,x,3))
names(reports)<-c("ID","date","text") #creates data frame with columns ID and Text
for (i in 1:x) {
  texto<-paste(readLines(files[i]),collapse="\n ")
  strip(texto,char.keep=c(".","?","!","-","+","±","~","=","&","%","$","£","@","*","(",")",":",";",">","<"))
  reports$ID[i] <- files.ID[i]
  reports$date[i] <- files.date[i]
  reports$text[i] <- texto
}