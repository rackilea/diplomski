getInvites().stream()
            .filter(i -> token.equals(i.getToken()))
            .forEach(i -> {
                if (i.isConfirm()) 
                    throw new CustomException();
                else 
                    i.setConfirm(true);
            });