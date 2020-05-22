protected void desmarcaDocumentoPrincipal(PessoaDocumentoIdentificacao documento,Pessoa pessoa) {

     if (documento.getDocumentoPrincipal()) {
         if (!documento.getUsadoFalsamente() && documento.getAtivo() && documento.getTipoDocumento().getIdentificador() && pesquisaDocumentoPrincipal(documento) != null) {

            StringBuffer sb = new StringBuffer();
                sb.append("update tb_pess_doc_identificacao set in_principal=false ");
                sb.append("where id_pessoa = :pessoa ");
                sb.append("and id_pessoa_doc_identificacao != :idDocumentoIdentificacao");
            String sql = sb.toString();
                sql = sql.replaceAll(":pessoa", String.valueOf(documento.getPessoa().getIdPessoa()));
                sql = sql.replaceAll(":idDocumentoIdentificacao", String.valueOf(documento.getIdDocumentoIdentificacao()));

            EntityManager em = EntityUtil.getEntityManager();   
            em.createNativeQuery(sql).executeUpdate();
            em.refresh(pessoa);

        refreshGrid("pessoaDocumentoIdentificacaoPreCadastroGrid");
        refreshGrid("pessoaDocumentoIdentificacaoCadastroGrid");
        }
     }
 }