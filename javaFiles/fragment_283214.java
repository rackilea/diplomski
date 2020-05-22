Person participants[] = new Person[lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            StringTokenizer st = new StringTokenizer(lines.get(i), "!");
            String[] fields = new String[4];
            for (int k = 0; k < fields.length && st.hasMoreTokens(); k++)
                fields[k] = st.nextToken();
            participants[i++] = new Person(fields[0], fields[1], fields[2], fields[3]);
        }

        return participants;
    }
}