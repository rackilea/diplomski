public int getResponseCode() throws IOException {
454        /*
455         * We're got the response code already
456         */
457        if (responseCode != -1) {
458            return responseCode;
459        }
460
461        /*
462         * Ensure that we have connected to the server. Record
463         * exception as we need to re-throw it if there isn't
464         * a status line.
465         */
466        Exception exc = null;
467        try {
468            getInputStream();
469        } catch (Exception e) {
470            exc = e;
471        }
472        ...