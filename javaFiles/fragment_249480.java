delimiter $$
CREATE OR REPLACE PROCEDURE updateAward(p_total_amount in Number, p_no_of_sales in Number, p_agent in NUMBER, p_id in NUMBER) AS
    BEGIN
      update Award set total_amount = p_total_amount, no_of_sales = p_no_of_sales, agent_id = p_agent where ID = p_id;
      commit;
    END;
$$
delimiter ;