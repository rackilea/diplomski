Map<String, Double> entityOutgoingReport = 
      tradeList.stream()
               .filter(trade -> trade.getInstruction() == Instruction.SELL)
               .sorted(Comparator.comparing(trade -> trade.getInstructionDate()))
               .collect(Collectors.groupingBy(trade -> String.valueOf(trade.getEntity()),
                        LinkedHashMap::new,
                        Collectors.summingDouble(trade -> trade.getUSDAmount())));