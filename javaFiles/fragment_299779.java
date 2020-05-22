for i, roi in enumerate(roi_list):
    roi_img, roi_x_offset, roi_y_offset = roi
    print("#roi:{} x:{} y:{}".format(i, roi_x_offset, roi_y_offset))

    roi_img_blur_threshold = cv2.Canny(roi_img, 40, 200)
    cv2.imshow("ROI image", roi_img_blur_threshold)
    cv2.waitKey()