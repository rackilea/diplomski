let pdf = Pdfread.pdf_of_file None in_file ;;

let pdf =
  let (pdf,_perms) = Pdfcrypt.decrypt_pdf "" pdf in
  match pdf with
  | Some pdf -> pdf
  | None -> failwith "Could not decrypt"
;;

let pdf = Pdfmarks.remove_bookmarks pdf ;;

let pages = Pdfdoc.pages_of_pagetree pdf ;;

let pages = List.fold_right (fun page acc ->
  let (y1,x1,y2,x2) = Pdf.parse_rectangle page.Pdfdoc.mediabox in
  let box y1 x1 y2 x2 = Pdf.Array
    [ Pdf.Real y1; Pdf.Real x1; Pdf.Real y2; Pdf.Real x2 ]
  in
  let xm = x1 *. 0.5 +. x2 *. 0.5 in
  let pagel = {page with Pdfdoc.mediabox = box y1 x1 y2 xm}
  and pager = {page with Pdfdoc.mediabox = box y1 xm y2 x2}
  in pagel::pager::acc
) pages [] ;;

let pdf = Pdfdoc.change_pages false pdf pages ;;

Pdf.remove_unreferenced pdf ;;

Pdfwrite.pdf_to_file pdf out_file ;;