scene.setOnKeyPressed(event -> {input = event.getCode().toString();
            for (String acceptedKey : acceptedKeys) {
                if (event.getCode().toString().contains(acceptedKey)) {
                    acceptedKeyBeingPressed = true;
                    break;
                }
            }
        });
scene.setOnKeyReleased(event -> acceptedKeyBeingPressed = false);