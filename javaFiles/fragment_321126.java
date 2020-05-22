case 4:
        System.out.print("\nPlease enter a tip percentage: ");
        fUserTipPercentage = Keyboard.nextShort();
        fTipAmt = ((fUserTipPercentage / ONE_HUNDRED) * fPurchaseAmt);
        System.out.print(
                        "\nA " + fUserTipPercentage + "% tip for a " +
                        dfMoney.format(fPurchaseAmt) + "  purchase would be " +
                        dfMoney.format(fTipAmt));
           <<-----------------------  No break!
    default:
        fTipAmt = 0.0f;  <<----- therefore executing will continue here.
        System.out.print("\n\tERROR");
        break;
    }