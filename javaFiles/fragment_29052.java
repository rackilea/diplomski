public static void makeTransactions(int[] trans, int amount) {
        int position = findNr(trans);
        if (position == -1) {
            moveTrans(trans);
            position = findNr(trans);
            trans[position] = amount;
        } else {
            if (position != 0 && position == trans.length - 1) {
            // shift the elements back
            for (int i = 0; i < position; i++)
                trans[i] = trans[i] + 1;
            trans[position - 1] = amount;
        }else
            trans[position] = amount;
        }

}