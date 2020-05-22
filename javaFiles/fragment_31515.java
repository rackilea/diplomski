....
                <td class="text-center">
                ....
                <c:if test="${withdrawal.transferred == false}">
                    <button class="btn btn-warning btn-sm md-trigger" data-modal="form-primary" type="button"
                    onclick="document.getElementById('transferredId').value=${withdrawal.id}">
                    Pending
                    </button>
                </c:if>
            </td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<div class="md-modal colored-header danger custom-width md-effect-9" id="form-primary">
    <div class="md-content">
        <div class="modal-header">
            <h3>Confirm Withdrawal Request</h3>
            <button type="button" class="close md-close" data-dismiss="modal" aria-hidden="true">&times;</button>
        </div>
        <div class="modal-body form">
            <div class="form-group">
                <label class="col-sm-3 control-label">Admin Name</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" name="adminName" value="${adminName}">
                    <input type="text" class="form-control" name="transferredId" id="transferredId" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">Transfer Reference</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" name="transferReference">
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default btn-flat md-close" data-dismiss="modal">Cancel</button>
            <button type="submit" class="btn btn-danger btn-flat md-close" name="submitRequest">Submit</button>
        </div>
    </div>
</div>