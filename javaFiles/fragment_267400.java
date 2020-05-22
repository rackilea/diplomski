if (!auxAmounts.isEmpty()) {
            LinkedList<InvtQaTracer> result = new LinkedList<InvtQaTracer>();
            //Updated Here
            InvtQaTracer trx = null;
            List<BigDecimal> auxAmounts = new ArrayList<BigDecimal>(); //[-9.000000, -6.000000]
            for (BigDecimal asss : auxAmounts) {
                System.out.println(asss);
            //Updated Here
            trx = new InvtQaTracer();
                trx.setTrxQty(asss);
                result.addFirst(trx);
            }
        } else {
            result.addFirst(trx);
        }