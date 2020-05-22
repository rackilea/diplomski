IntStream.range(0, reversed.size())
            .filter(idx -> idx % 2 == 0)
            .forEach(idx -> {
                UserModel userModel1 = reversed.get(idx);
                UserModel userModel2 = idx + 1 < reversed.size() ? reversed.get(idx + 1) : null;
                result.add(UserPairModel.from(userModel1, userModel2));
            });