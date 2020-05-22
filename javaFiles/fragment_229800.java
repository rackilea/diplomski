for (Connection c : n.getInputs()) {

    for (Connection c2 : nrNew.getConnections()) {

        if (c.getId() != c2.getId() || !c2.isEnabled()) {

            n.getInputs().remove(c);

        }

    }

}

//CONCURRENT MODIFICATION EXCEPTION
for (Connection c : n.getOutputs()) {

    for (Connection c2 : nrNew.getConnections()) {

        if (c.getId() != c2.getId() || !c2.isEnabled()) {

            n.getOutputs().remove(c);

        }

    }

}