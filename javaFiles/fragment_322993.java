if (token.index() < reprMent.startIndex || token.index() > reprMent.endIndex) {

                for (int i = reprMent.startIndex; i < reprMent.endIndex; i++) {
                    CoreLabel matchedLabel = corefSentenceTokens.get(i - 1); 
                    resolved.add(matchedLabel.word());

                    newwords += matchedLabel.word() + " ";

                }
            }

            else {
                resolved.add(token.word());

            }