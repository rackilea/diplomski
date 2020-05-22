case 4:
        System.out.println("Encontrar horário de um curso");
        idCurso = sq.nextInt();
        List<HorariosCurso> h = findHorarioCurso(idCurso);
        for(HorariosCurso hc:h)
            System.out.println(hc.getDesignacao()+hc.getDesignacaoCurso()+hc.getDia()+hc.getFim()+hc.getInicio());
        break;