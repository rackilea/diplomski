do {
            read = `in`.read(buffer)
            handler.post(ProgressUpdater(uploaded, fileLength!!))

            if (read == -1) {
                break
            }

            uploaded += read.toLong()
            sink.write(buffer, 0, read)

        } while (true)