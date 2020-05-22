try{
        QtFastStart.fastStart(inputFile, outputFile); // Adds moov to your input
                   // Now your output file is ready to stream!
        }catch (QtFastStart.MalformedFileException m){
            logger.error("QT", m);
        }catch (QtFastStart.UnsupportedFileException q){
            logger.error("QT", q);
        }catch (IOException i){
            logger.error("QT", i);              
        }