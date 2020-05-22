getInvites().stream()
            .filter(i -> token.equals(i.getToken()))
            .filter(i -> !i.isConfirm())
            .findAny()
            .orElseThrow(IllegalArgumentException::new)
            .setConfirm(true);