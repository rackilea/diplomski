boolean multiLineComment = false;
    while (( line = reader.readLine()) != null) {
      if (!isLineAMultiLineCommentStart(line)) {
        multiLineComment = true;
      }

      if (multiLineComment) {
        if (!isLineAMultiLineCommentEnd(line)) {
          multiLineComment = false;
        }
      }

      if (!isLineAComment(line) && !multiLineComment) {
        stringBuilder.append(line);
        stringBuilder.append(ls);
      }
    }