requests.add(new Request().setFindReplace(new FindReplaceRequest().setFind(entry.getKey())
                .setMatchEntireCell(true)
                .setMatchCase(true)
                .setReplacement(entry.getValue())
                .setRange(new GridRange()
                        .setSheetId(0)
                        .setStartRowIndex(row)
                        .setEndRowIndex(row + 1))));
    }



    String cellReq = (new FindReplaceRequest().setFind("samuel")).getFind();