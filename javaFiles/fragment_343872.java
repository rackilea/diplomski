if(codigoPaciente.compareTo("") != 0)
            {
                queryS += " and c.CodigoDoPaciente =:paciente";
            }

Query query = em.createQuery(queryS);

// etc etc...
if(codigoPaciente.compareTo("") != 0)
    query.setParameter("paciente", codigoPaciente);