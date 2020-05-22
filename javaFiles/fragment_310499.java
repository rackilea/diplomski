SELECT *
    FROM ( (SELECT DISTINCT (doc_hdr.doc_hdr_id),
                            doc_hdr.initr_prncpl_id,
                            doc_hdr.doc_hdr_stat_cd,
                            doc_hdr.crte_dt,
                            doc_hdr.ttl,
                            doc_hdr.app_doc_stat,
                            doc1.doc_typ_nm,
                            doc1.lbl,
                            doc1.doc_hdlr_url,
                            doc1.actv_ind
              FROM krew_doc_typ_t doc1, krew_doc_hdr_t doc_hdr
             WHERE doc_hdr.initr_prncpl_id IN ('10000000001')
               AND (doc1.doc_typ_nm = 'PO'
                 OR doc1.doc_typ_nm = 'POA'
                 OR doc1.doc_typ_nm = 'POC'
                 OR doc1.doc_typ_nm = 'POPH'
                 OR doc1.doc_typ_nm = 'PORH'
                 OR doc1.doc_typ_nm = 'POR'
                 OR doc1.doc_typ_nm = 'PORT'
                 OR doc1.doc_typ_nm = 'POSP'
                 OR doc1.doc_typ_nm = 'POV')
               AND doc_hdr.doc_hdr_stat_cd != 'I'
               AND doc_hdr.doc_typ_id = doc1.doc_typ_id)
          UNION
          SELECT DISTINCT doc_hdr.doc_hdr_id,
                          doc_hdr.initr_prncpl_id,
                          doc_hdr.doc_hdr_stat_cd,
                          doc_hdr.crte_dt,
                          doc_hdr.ttl,
                          doc_hdr.app_doc_stat,
                          doc1.doc_typ_nm,
                          doc1.lbl,
                          doc1.doc_hdlr_url,
                          doc1.actv_ind
            FROM krew_doc_typ_t doc1, krew_doc_hdr_t doc_hdr
           WHERE doc1.doc_typ_nm = 'PO'
             AND CAST (doc_hdr.doc_hdr_id AS VARCHAR (14)) =
                     ANY (SELECT ppt.fdoc_nbr
                            FROM pur_po_t ppt, pl_purchase_log_po_t ppl
                           WHERE ppt.ap_pur_doc_lnk_id =
                                     ANY (SELECT prt.ap_pur_doc_lnk_id
                                            FROM pur_reqs_t prt,
                                                 krew_doc_hdr_t doc_hdr
                                           WHERE CAST (
                                                     doc_hdr.doc_hdr_id AS VARCHAR (14)
                                                 ) = prt.fdoc_nbr
                                             AND doc_hdr.initr_prncpl_id IN
                                                         ('10000000001'))))
         final_search
ORDER BY final_search.doc_hdr_id DESC;