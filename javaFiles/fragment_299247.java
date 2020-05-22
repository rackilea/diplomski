do {
            read = `in`.read(buffer)

            if (read == -1) {
                break
            }

            uploaded += read.toLong()
            sink.write(buffer, 0, read)
            handler.post(ProgressUpdater(uploaded, fileLength!!))

        } while (true)